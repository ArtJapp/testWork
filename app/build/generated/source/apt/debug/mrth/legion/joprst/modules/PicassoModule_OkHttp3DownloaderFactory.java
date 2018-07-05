// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package mrth.legion.joprst.modules;

import com.squareup.picasso.OkHttp3Downloader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class PicassoModule_OkHttp3DownloaderFactory implements Factory<OkHttp3Downloader> {
  private final PicassoModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public PicassoModule_OkHttp3DownloaderFactory(
      PicassoModule module, Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public OkHttp3Downloader get() {
    return Preconditions.checkNotNull(
        module.okHttp3Downloader(okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttp3Downloader> create(
      PicassoModule module, Provider<OkHttpClient> okHttpClientProvider) {
    return new PicassoModule_OkHttp3DownloaderFactory(module, okHttpClientProvider);
  }
}
