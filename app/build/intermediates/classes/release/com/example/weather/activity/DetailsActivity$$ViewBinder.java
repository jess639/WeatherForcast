// Generated code from Butter Knife. Do not modify!
package com.example.weather.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DetailsActivity$$ViewBinder<T extends com.example.weather.activity.DetailsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492973, "field 'back'");
    target.back = finder.castView(view, 2131492973, "field 'back'");
    view = finder.findRequiredView(source, 2131492974, "field 'aboutUs'");
    target.aboutUs = finder.castView(view, 2131492974, "field 'aboutUs'");
    view = finder.findRequiredView(source, 2131492975, "field 'progress'");
    target.progress = finder.castView(view, 2131492975, "field 'progress'");
    view = finder.findRequiredView(source, 2131492976, "field 'mListView'");
    target.mListView = finder.castView(view, 2131492976, "field 'mListView'");
  }

  @Override public void unbind(T target) {
    target.back = null;
    target.aboutUs = null;
    target.progress = null;
    target.mListView = null;
  }
}
