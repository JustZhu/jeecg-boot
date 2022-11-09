package org.jeecg.modules.quartz.job;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.labor.entity.LaborCompJn;
import com.labor.service.ILaborCompJnService;
import com.labor.service.IPubOrganService;
import com.labor.system.entity.AcmGhxx;
import com.labor.system.service.IAcmGhxxService;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.util.DateUtils;
import org.jeecg.modules.demo.com.acm.async.entity.PubOrgan;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 工会同步任务
 *
 * @Author Scott
 */
@Slf4j
public class AsyncGhxxJob implements Job
{
    @Autowired
    public ILaborCompJnService jnService;
    @Autowired
    public IPubOrganService pubOrganService;
    @Autowired
    public IAcmGhxxService ghxxService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        log.info(" Job Execution key：" + jobExecutionContext.getJobDetail().getKey());
        log.info(String.format("  工会同步任务开始 AsyncGhxxJob !  时间:" + DateUtils.getTimestamp()));
        this.init();
        this.CopyData("");
        jnService.queryGhListByGhbm("");
    }

    private void CopyData(String parentId)
    {
        if (StrUtil.isEmpty(parentId))
        {
            parentId = "O370100000000";
        }

        PubOrgan pubOrgan = this.pubOrganService.getOne(new QueryWrapper<PubOrgan>().eq("organ_Id", parentId));
        String organCode = pubOrgan.getOrganCode();
        AcmGhxx sjgh = this.ghxxService.getOne(new QueryWrapper<AcmGhxx>().eq("ghbm", organCode));
        String sjghbm = sjgh.getGhbm();
        String sjghmc = sjgh.getGhmc();
        String pid = sjgh.getId();
        if (jnService.hasChild(parentId))
        {
            List<LaborCompJn> list = jnService.queryGhListByGhbm(parentId);
            for (LaborCompJn item : list)
            {
                AcmGhxx ghxx = this.ghxxService.getOne(new QueryWrapper<AcmGhxx>().eq("ghbm", item.getOrganCode()));
                boolean hasChild = jnService.hasChild(item.getOrganId());
                if (null == ghxx)
                {
                    ghxx = new AcmGhxx();
                    ghxx.setGhbm(item.getOrganCode());
                    ghxx.setGhmc(item.getOrganName());
                    ghxx.setQxbm(item.getQxcode());
                    ghxx.setQxmc(item.getQxname());
                    ghxx.setJdbm(item.getJdcode());
                    ghxx.setJdmc(item.getJdname());
                    ghxx.setSjbm(sjghbm);
                    ghxx.setSjmc(sjghmc);
                    ghxx.setPid(pid);
                    ghxx.setHasChild(hasChild ? "1" : "0");
                    if (StrUtil.isNotEmpty(item.getCtime()))
                    {
                        ghxx.setJhrq(DateUtil.parse(item.getCtime(), DatePattern.NORM_DATE_PATTERN));
                    }
                    this.ghxxService.save(ghxx);
                }

                if (hasChild)
                {
                    this.CopyData(item.getOrganId());
                }
            }
        }
    }

    public void init()
    {
        AcmGhxx zgh = this.ghxxService.getOne(new QueryWrapper<AcmGhxx>().eq("ghbm", "370100000000"));
        if (null == zgh)
        {

            PubOrgan pubOrgan = this.pubOrganService.getOne(new QueryWrapper<PubOrgan>().eq("organ_Id", "O370100000000"));
            zgh = new AcmGhxx();
            zgh.setGhbm(pubOrgan.getOrganCode());
            zgh.setGhmc(pubOrgan.getOrganName());
            zgh.setPid("0");
            zgh.setHasChild("1");
            if (StrUtil.isNotEmpty(pubOrgan.getCtime()))
            {
                zgh.setJhrq(DateUtil.parse(pubOrgan.getCtime(), DatePattern.NORM_DATE_PATTERN));
            }
            this.ghxxService.save(zgh);
        }
    }
}
