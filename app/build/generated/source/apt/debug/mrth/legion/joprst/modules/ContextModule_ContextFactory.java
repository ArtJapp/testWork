// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package mrth.legion.joprst.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ContextModule_ContextFactory implements Factory<Context> {
  private final ContextModule module;

  public ContextModule_ContextFactory(ContextModule module) {
    this.module = module;
  }

  @Override
  public Context get() {
    return Preconditions.checkNotNull(
        module.context(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Context> create(ContextModule module) {
    return new ContextModule_ContextFactory(module);
  }
}
