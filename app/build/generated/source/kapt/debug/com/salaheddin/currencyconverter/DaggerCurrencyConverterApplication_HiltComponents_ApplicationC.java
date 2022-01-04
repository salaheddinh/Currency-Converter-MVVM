package com.salaheddin.currencyconverter;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.salaheddin.currencyconverter.data.network.CurrencyAPI;
import com.salaheddin.currencyconverter.di.AppModule;
import com.salaheddin.currencyconverter.di.AppModule_ProvideCurrencyApiFactory;
import com.salaheddin.currencyconverter.di.AppModule_ProvideDispatchersFactory;
import com.salaheddin.currencyconverter.di.AppModule_ProvideMainRepositoryFactory;
import com.salaheddin.currencyconverter.repository.MainRepository;
import com.salaheddin.currencyconverter.ui.main.MainActivity;
import com.salaheddin.currencyconverter.ui.main.MainViewModel_AssistedFactory;
import com.salaheddin.currencyconverter.ui.main.MainViewModel_AssistedFactory_Factory;
import com.salaheddin.currencyconverter.utils.DispatcherProvider;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerCurrencyConverterApplication_HiltComponents_ApplicationC extends CurrencyConverterApplication_HiltComponents.ApplicationC {
  private final ApplicationContextModule applicationContextModule;

  private volatile Object currencyAPI = new MemoizedSentinel();

  private volatile Object mainRepository = new MemoizedSentinel();

  private volatile Provider<MainRepository> provideMainRepositoryProvider;

  private volatile Object dispatcherProvider = new MemoizedSentinel();

  private volatile Provider<DispatcherProvider> provideDispatchersProvider;

  private DaggerCurrencyConverterApplication_HiltComponents_ApplicationC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private CurrencyAPI getCurrencyAPI() {
    Object local = currencyAPI;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = currencyAPI;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideCurrencyApiFactory.provideCurrencyApi();
          currencyAPI = DoubleCheck.reentrantCheck(currencyAPI, local);
        }
      }
    }
    return (CurrencyAPI) local;
  }

  private MainRepository getMainRepository() {
    Object local = mainRepository;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = mainRepository;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideMainRepositoryFactory.provideMainRepository(getCurrencyAPI());
          mainRepository = DoubleCheck.reentrantCheck(mainRepository, local);
        }
      }
    }
    return (MainRepository) local;
  }

  private Provider<MainRepository> getMainRepositoryProvider() {
    Object local = provideMainRepositoryProvider;
    if (local == null) {
      local = new SwitchingProvider<>(0);
      provideMainRepositoryProvider = (Provider<MainRepository>) local;
    }
    return (Provider<MainRepository>) local;
  }

  private DispatcherProvider getDispatcherProvider() {
    Object local = dispatcherProvider;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = dispatcherProvider;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideDispatchersFactory.provideDispatchers();
          dispatcherProvider = DoubleCheck.reentrantCheck(dispatcherProvider, local);
        }
      }
    }
    return (DispatcherProvider) local;
  }

  private Provider<DispatcherProvider> getDispatcherProviderProvider() {
    Object local = provideDispatchersProvider;
    if (local == null) {
      local = new SwitchingProvider<>(1);
      provideDispatchersProvider = (Provider<DispatcherProvider>) local;
    }
    return (Provider<DispatcherProvider>) local;
  }

  @Override
  public void injectCurrencyConverterApplication(
      CurrencyConverterApplication currencyConverterApplication) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public CurrencyConverterApplication_HiltComponents.ApplicationC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerCurrencyConverterApplication_HiltComponents_ApplicationC(applicationContextModule);
    }
  }

  private final class ActivityRetainedCBuilder implements CurrencyConverterApplication_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public CurrencyConverterApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends CurrencyConverterApplication_HiltComponents.ActivityRetainedC {
    private ActivityRetainedCImpl() {

    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    private final class ActivityCBuilder implements CurrencyConverterApplication_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public CurrencyConverterApplication_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends CurrencyConverterApplication_HiltComponents.ActivityC {
      private final Activity activity;

      private volatile Provider<MainViewModel_AssistedFactory> mainViewModel_AssistedFactoryProvider;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private MainViewModel_AssistedFactory getMainViewModel_AssistedFactory() {
        return MainViewModel_AssistedFactory_Factory.newInstance(DaggerCurrencyConverterApplication_HiltComponents_ApplicationC.this.getMainRepositoryProvider(), DaggerCurrencyConverterApplication_HiltComponents_ApplicationC.this.getDispatcherProviderProvider());
      }

      private Provider<MainViewModel_AssistedFactory> getMainViewModel_AssistedFactoryProvider() {
        Object local = mainViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          mainViewModel_AssistedFactoryProvider = (Provider<MainViewModel_AssistedFactory>) local;
        }
        return (Provider<MainViewModel_AssistedFactory>) local;
      }

      private Map<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>> getMapOfStringAndProviderOfViewModelAssistedFactoryOf(
          ) {
        return Collections.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>singletonMap("com.salaheddin.currencyconverter.ui.main.MainViewModel", (Provider) getMainViewModel_AssistedFactoryProvider());
      }

      private ViewModelProvider.Factory getProvideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerCurrencyConverterApplication_HiltComponents_ApplicationC.this.applicationContextModule), getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
      }

      @Override
      public void injectMainActivity(MainActivity arg0) {
      }

      @Override
      public Set<ViewModelProvider.Factory> getActivityViewModelFactory() {
        return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      private final class FragmentCBuilder implements CurrencyConverterApplication_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public CurrencyConverterApplication_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends CurrencyConverterApplication_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory getProvideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerCurrencyConverterApplication_HiltComponents_ApplicationC.this.applicationContextModule), ActivityCImpl.this.getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
        }

        @Override
        public Set<ViewModelProvider.Factory> getFragmentViewModelFactory() {
          return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        private final class ViewWithFragmentCBuilder implements CurrencyConverterApplication_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public CurrencyConverterApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends CurrencyConverterApplication_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements CurrencyConverterApplication_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public CurrencyConverterApplication_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends CurrencyConverterApplication_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.salaheddin.currencyconverter.ui.main.MainViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getMainViewModel_AssistedFactory();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements CurrencyConverterApplication_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public CurrencyConverterApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends CurrencyConverterApplication_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }

  private final class SwitchingProvider<T> implements Provider<T> {
    private final int id;

    SwitchingProvider(int id) {
      this.id = id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
      switch (id) {
        case 0: // com.salaheddin.currencyconverter.repository.MainRepository 
        return (T) DaggerCurrencyConverterApplication_HiltComponents_ApplicationC.this.getMainRepository();

        case 1: // com.salaheddin.currencyconverter.utils.DispatcherProvider 
        return (T) DaggerCurrencyConverterApplication_HiltComponents_ApplicationC.this.getDispatcherProvider();

        default: throw new AssertionError(id);
      }
    }
  }
}
