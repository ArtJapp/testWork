// Generated code from Butter Knife. Do not modify!
package mrth.legion.joprst;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.btnSubmit = Utils.findRequiredViewAsType(source, R.id.btnSearch, "field 'btnSubmit'", Button.class);
    target.etSearchField = Utils.findRequiredViewAsType(source, R.id.etSearchField, "field 'etSearchField'", EditText.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.rvSearchResults, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnSubmit = null;
    target.etSearchField = null;
    target.recyclerView = null;
  }
}
