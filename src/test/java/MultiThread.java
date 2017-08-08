import sun.management.ManagementFactoryHelper;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by forvoid on 2017/7/31.
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(" ["+threadInfo.getThreadId()+"]" + threadInfo.getThreadName());
        }
    }
}
