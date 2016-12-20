package com.bujilvxing.app;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.bujilvxing.BuildConfig;
import com.bujilvxing.ui.manager.AccountManager;
import com.bujilvxing.ui.manager.PreferenceManager;
import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;
import com.elvishew.xlog.printer.Printer;
import com.elvishew.xlog.printer.file.FilePrinter;
import com.elvishew.xlog.printer.file.backup.NeverBackupStrategy;
import com.elvishew.xlog.printer.file.naming.DateFileNameGenerator;
import com.facebook.stetho.Stetho;


/**
 */
public class AndroidApplication extends MultiDexApplication {

    private static AndroidApplication sInstance;
    private static final boolean DEBUG = BuildConfig.DEVELOPER_MODE;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initFresco();
        if (isDebug()) {
            Stetho.initializeWithDefaults(sInstance);

            LogConfiguration config = new LogConfiguration.Builder()
                    .logLevel(BuildConfig.DEBUG ? LogLevel.ALL             // 指定日志级别，低于该级别的日志将不会被打印，默认为 LogLevel.ALL
                            : LogLevel.NONE)
                    .tag("BUJILVXING")                                         // 指定 TAG，默认为 "X-LOG"
                    .t()                                                   // 允许打印线程信息，默认禁止
                    .st(2)                                                 // 允许打印深度为2的调用栈信息，默认禁止
                    .b().build();


            Printer filePrinter = new FilePrinter                      // 打印日志到文件的打印器
                    .Builder("/sdcard/xlog/")                              // 指定保存日志文件的路径
                    .fileNameGenerator(new DateFileNameGenerator())        // 指定日志文件名生成器，默认为 ChangelessFileNameGenerator("log")
                    .backupStrategy(new NeverBackupStrategy())              // 指定日志文件备份策略，默认为 FileSizeBackupStrategy(1024 * 1024)
//                            .logFlattener(new MyFlattener())                       // 指定日志平铺器，默认为 DefaultFlattener
                            .build();

            XLog.init(config, filePrinter);
        } else {
            XLog.init(LogLevel.NONE);
        }
//        initGloablExceptionHanler();
    }

    private void initFresco() {
//       ImagePipelineConfig config =  FrescoOkHttpImagePipelineConfigFactory.newBuilder(sInstance, HttpUtils.getHttpClient()).build();
//       Fresco.initialize(sInstance,config);
    }

    @Nullable
    public static AndroidApplication getInstance() {
        return sInstance;
    }


    @Nullable
    public PreferenceManager getPreferenceManager() {
        if (sInstance != null) {
            return PreferenceManager.getInstantce(sInstance);
        }
        return null;
    }

    @Nullable
    public AccountManager getAccountManager() {
        if (sInstance != null) {
            return AccountManager.getInstance(sInstance);
        }
        return null;
    }


    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
    }

    public boolean isDebug() {
        return DEBUG;
    }



//    public void initGloablExceptionHanler() {
//        new GlobalExceptionHandler(sInstance);
//    }

}
