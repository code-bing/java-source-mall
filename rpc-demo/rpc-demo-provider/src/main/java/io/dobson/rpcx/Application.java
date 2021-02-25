package io.dobson.rpcx;

import io.dobson.rpcx.server.RpcNettyServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner {
    private final RpcNettyServer rpcNettyServer;

    public Application(RpcNettyServer rpcNettyServer) {this.rpcNettyServer = rpcNettyServer;}

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        rpcNettyServer.run();
    }
}
