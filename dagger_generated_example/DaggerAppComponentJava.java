// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.topake.dagger2kotlinsample.di;

import android.app.Activity;
import android.app.Application;
import com.example.topake.dagger2kotlinsample.core.PlayGroundApp;
import com.example.topake.dagger2kotlinsample.core.PlayGroundApp_MembersInjector;
import com.example.topake.dagger2kotlinsample.helper.DummyContextDependentHelper;
import com.example.topake.dagger2kotlinsample.helper.DummyHelper;
import com.example.topake.dagger2kotlinsample.main.MainActivity;
import com.example.topake.dagger2kotlinsample.main.MainActivityModule;
import com.example.topake.dagger2kotlinsample.main.MainActivityModule_ProvideDummyHelperFactory;
import com.example.topake.dagger2kotlinsample.main.MainActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

public final class DaggerAppComponentJava implements AppComponentJava {
  private Provider<ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Builder>
      mainActivitySubcomponentBuilderProvider;

  private Provider<AndroidInjector.Factory<? extends Activity>> bindAndroidInjectorFactoryProvider;

  private Provider<
          Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>>>
      mapOfClassOfAndProviderOfFactoryOfProvider;

  private Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider;

  private MembersInjector<PlayGroundApp> playGroundAppMembersInjector;

  private Provider<Application> applicationProvider;

  private Provider<DummyContextDependentHelper> provideSharedPrefHelperProvider;

  private DaggerAppComponentJava(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static AppComponentJava.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.mainActivitySubcomponentBuilderProvider =
        new dagger.internal.Factory<
            ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Builder>() {
          @Override
          public ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Builder get() {
            return new MainActivitySubcomponentBuilder();
          }
        };

    this.bindAndroidInjectorFactoryProvider = (Provider) mainActivitySubcomponentBuilderProvider;

    this.mapOfClassOfAndProviderOfFactoryOfProvider =
        MapProviderFactory
            .<Class<? extends Activity>, AndroidInjector.Factory<? extends Activity>>builder(1)
            .put(MainActivity.class, bindAndroidInjectorFactoryProvider)
            .build();

    this.dispatchingAndroidInjectorProvider =
        DispatchingAndroidInjector_Factory.create(mapOfClassOfAndProviderOfFactoryOfProvider);

    this.playGroundAppMembersInjector =
        PlayGroundApp_MembersInjector.create(dispatchingAndroidInjectorProvider);

    this.applicationProvider = InstanceFactory.create(builder.application);

    this.provideSharedPrefHelperProvider =
        DoubleCheck.provider(
            AppModule_ProvideSharedPrefHelperFactory.create(
                builder.appModule, applicationProvider));
  }

  @Override
  public void inject(PlayGroundApp app) {
    playGroundAppMembersInjector.injectMembers(app);
  }

  private static final class Builder implements AppComponentJava.Builder {
    private AppModule appModule;

    private Application application;

    @Override
    public AppComponentJava build() {
      if (appModule == null) {
        this.appModule = new AppModule();
      }
      if (application == null) {
        throw new IllegalStateException(Application.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponentJava(this);
    }

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }
  }

  private final class MainActivitySubcomponentBuilder
      extends ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Builder {
    private MainActivityModule mainActivityModule;

    private MainActivity seedInstance;

    @Override
    public ActivityBuilder_BindMainActivity.MainActivitySubcomponent build() {
      if (mainActivityModule == null) {
        this.mainActivityModule = new MainActivityModule();
      }
      if (seedInstance == null) {
        throw new IllegalStateException(MainActivity.class.getCanonicalName() + " must be set");
      }
      return new MainActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(MainActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class MainActivitySubcomponentImpl
      implements ActivityBuilder_BindMainActivity.MainActivitySubcomponent {
    private Provider<DummyHelper> provideDummyHelperProvider;

    private MembersInjector<MainActivity> mainActivityMembersInjector;

    private MainActivitySubcomponentImpl(MainActivitySubcomponentBuilder builder) {
      assert builder != null;
      initialize(builder);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final MainActivitySubcomponentBuilder builder) {

      this.provideDummyHelperProvider =
          MainActivityModule_ProvideDummyHelperFactory.create(builder.mainActivityModule);

      this.mainActivityMembersInjector =
          MainActivity_MembersInjector.create(
              DaggerAppComponentJava.this.provideSharedPrefHelperProvider,
              provideDummyHelperProvider);
    }

    @Override
    public void inject(MainActivity arg0) {
      mainActivityMembersInjector.injectMembers(arg0);
    }
  }
}