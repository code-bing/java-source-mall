package io.dobson.rpcx;

import io.dobson.rpcx.server.RpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication implements ApplicationRunner {
    private final RpcServer rpcNettyServer;

    @Autowired
    public ServerApplication(RpcServer rpcNettyServer) {this.rpcNettyServer = rpcNettyServer;}

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class);
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            rpcNettyServer.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
            rpcNettyServer.shutdown();
        }
    }
}
