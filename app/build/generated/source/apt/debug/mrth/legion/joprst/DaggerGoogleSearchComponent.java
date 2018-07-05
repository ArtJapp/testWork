// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package mrth.legion.joprst;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.internal.Preconditions;
import java.io.File;
import mrth.legion.joprst.modules.ContextModule;
import mrth.legion.joprst.modules.GoogleSearchModule;
import mrth.legion.joprst.modules.OkHttpClientModule;
import mrth.legion.joprst.modules.PicassoModule;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class DaggerGoogleSearchComponent implements GoogleSearchComponent {
  private ContextModule contextModule;

  private OkHttpClientModule okHttpClientModule;

  private GoogleSearchModule googleSearchModule;

  private PicassoModule picassoModule;

  private DaggerGoogleSearchComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  private File getFile() {
    return Preconditions.checkNotNull(
        okHttpClientModule.file(
            Preconditions.checkNotNull(
                contextModule.context(),
                "Cannot return null from a non-@Nullable @Provides method")),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  private Cache getCache() {
    return Preconditions.checkNotNull(
        okHttpClientModule.cache(getFile()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  private OkHttpClient getOkHttpClient() {
    return Preconditions.checkNotNull(
        okHttpClientModule.okHttpClient(getCache()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  private GsonConverterFactory getGsonConverterFactory() {
    return Preconditions.checkNotNull(
        googleSearchModule.gsonConverterFactory(
            Preconditions.checkNotNull(
                googleSearchModule.gson(),
                "Cannot return null from a non-@Nullable @Provides method")),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  private Retrofit getRetrofit() {
    return Preconditions.checkNotNull(
        googleSearchModule.retrofit(
            getOkHttpClient(),
            getGsonConverterFactory(),
            Preconditions.checkNotNull(
                googleSearchModule.gson(),
                "Cannot return null from a non-@Nullable @Provides method")),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  private OkHttp3Downloader getOkHttp3Downloader() {
    return Preconditions.checkNotNull(
        picassoModule.okHttp3Downloader(getOkHttpClient()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.contextModule = builder.contextModule;
    this.okHttpClientModule = builder.okHttpClientModule;
    this.googleSearchModule = builder.googleSearchModule;
    this.picassoModule = builder.picassoModule;
  }

  @Override
  public Api getGoogleSearchService() {
    return Preconditions.checkNotNull(
        googleSearchModule.googleCuSearchAPI(getRetrofit()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  @Override
  public Picasso getPicasso() {
    return Preconditions.checkNotNull(
        picassoModule.picasso(
            Preconditions.checkNotNull(
                contextModule.context(),
                "Cannot return null from a non-@Nullable @Provides method"),
            getOkHttp3Downloader()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static final class Builder {
    private ContextModule contextModule;

    private OkHttpClientModule okHttpClientModule;

    private GoogleSearchModule googleSearchModule;

    private PicassoModule picassoModule;

    private Builder() {}

    public GoogleSearchComponent build() {
      if (contextModule == null) {
        throw new IllegalStateException(ContextModule.class.getCanonicalName() + " must be set");
      }
      if (okHttpClientModule == null) {
        this.okHttpClientModule = new OkHttpClientModule();
      }
      if (googleSearchModule == null) {
        this.googleSearchModule = new GoogleSearchModule();
      }
      if (picassoModule == null) {
        this.picassoModule = new PicassoModule();
      }
      return new DaggerGoogleSearchComponent(this);
    }

    public Builder googleSearchModule(GoogleSearchModule googleSearchModule) {
      this.googleSearchModule = Preconditions.checkNotNull(googleSearchModule);
      return this;
    }

    public Builder okHttpClientModule(OkHttpClientModule okHttpClientModule) {
      this.okHttpClientModule = Preconditions.checkNotNull(okHttpClientModule);
      return this;
    }

    public Builder contextModule(ContextModule contextModule) {
      this.contextModule = Preconditions.checkNotNull(contextModule);
      return this;
    }

    public Builder picassoModule(PicassoModule picassoModule) {
      this.picassoModule = Preconditions.checkNotNull(picassoModule);
      return this;
    }
  }
}