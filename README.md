## Java Api for FTX

samples in com.akalea.ftx.tools

```
FtxApi api = context.getBean(FtxApi.class);

FtxCredentials credentials =
    Optional
        .ofNullable(context.getBean(FtxCredentials.class))
        .orElse(
            new FtxCredentials()
                .setApiKey("api-key")
                .setApiSecret("api-secret"));

FtxAccount account = api.accounts().getAccount(credentials);
```

