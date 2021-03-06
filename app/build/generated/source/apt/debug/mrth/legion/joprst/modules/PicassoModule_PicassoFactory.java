// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package mrth.legion.joprst.modules;

import android.content.Context;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PicassoModule_PicassoFactory implements Factory<Picasso> {
  private final PicassoModule module;

  private final Provider<Context> contextProvider;

  private final Provider<OkHttp3Downloader> okHttp3DownloaderProvider;

  public PicassoModule_PicassoFactory(
      PicassoModule module,
      Provider<Context> contextProvider,
      Provider<OkHttp3Downloader> okHttp3DownloaderProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.okHttp3DownloaderProvider = okHttp3DownloaderProvider;
  }

  @Override
  public Picasso get() {
    return Preconditions.checkNotNull(
        module.picasso(contextProvider.get(), okHttp3DownloaderProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Picasso> create(
      PicassoModule module,
      Provider<Context> contextProvider,
      Provider<OkHttp3Downloader> okHttp3DownloaderProvider) {
    return new PicassoModule_PicassoFactory(module, contextProvider, okHttp3DownloaderProvider);
  }
}
