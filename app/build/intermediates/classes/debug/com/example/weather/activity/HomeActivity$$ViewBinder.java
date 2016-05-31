// Generated code from Butter Knife. Do not modify!
package com.example.weather.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HomeActivity$$ViewBinder<T extends com.example.weather.activity.HomeActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492973, "field 'back'");
    target.back = finder.castView(view, 2131492973, "field 'back'");
    view = finder.findRequiredView(source, 2131492988, "field 'add'");
    target.add = finder.castView(view, 2131492988, "field 'add'");
    view = finder.findRequiredView(source, 2131492975, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131492975, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131492987, "field 'cityName'");
    target.cityName = finder.castView(view, 2131492987, "field 'cityName'");
    view = finder.findRequiredView(source, 2131492976, "field 'mListView'");
    target.mListView = finder.castView(view, 2131492976, "field 'mListView'");
  }

  @Override public void unbind(T target) {
    target.back = null;
    target.add = null;
    target.progressBar = null;
    target.cityName = null;
    target.mListView = null;
  }
}
