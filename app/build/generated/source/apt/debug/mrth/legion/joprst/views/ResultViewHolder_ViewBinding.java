// Generated code from Butter Knife. Do not modify!
package mrth.legion.joprst.views;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import mrth.legion.joprst.R;

public class ResultViewHolder_ViewBinding implements Unbinder {
  private ResultViewHolder target;

  @UiThread
  public ResultViewHolder_ViewBinding(ResultViewHolder target, View source) {
    this.target = target;

    target.resultText = Utils.findRequiredViewAsType(source, R.id.textResult, "field 'resultText'", TextView.class);
    target.resultImage = Utils.findRequiredViewAsType(source, R.id.imageResult, "field 'resultImage'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ResultViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.resultText = null;
    target.resultImage = null;
  }
}
