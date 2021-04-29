package com.videoment.videocomment;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(5);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.ekoapp.ekosdk.uikit.DataBinderMapperImpl());
    result.add(new com.ekoapp.ekosdk.uikit.chat.DataBinderMapperImpl());
    result.add(new com.ekoapp.ekosdk.uikit.community.DataBinderMapperImpl());
    result.add(new com.ekoapp.ekosdk.upstra.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(48);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "addBottomSpace");
      sKeys.put(2, "alertColor");
      sKeys.put(3, "avatarUrl");
      sKeys.put(4, "clickListener");
      sKeys.put(5, "community");
      sKeys.put(6, "communityCategory");
      sKeys.put(7, "communityMemberShip");
      sKeys.put(8, "date");
      sKeys.put(9, "dateFillColor");
      sKeys.put(10, "delete");
      sKeys.put(11, "description");
      sKeys.put(12, "disable");
      sKeys.put(13, "edited");
      sKeys.put(14, "ekoCommunity");
      sKeys.put(15, "isCommunity");
      sKeys.put(16, "isJoined");
      sKeys.put(17, "isLoggedInUser");
      sKeys.put(18, "isModerator");
      sKeys.put(19, "isMyUser");
      sKeys.put(20, "isReplyComment");
      sKeys.put(21, "isSender");
      sKeys.put(22, "leftDrawable");
      sKeys.put(23, "leftString");
      sKeys.put(24, "listener");
      sKeys.put(25, "lonPressListener");
      sKeys.put(26, "menuItem");
      sKeys.put(27, "name");
      sKeys.put(28, "postCount");
      sKeys.put(29, "readOnly");
      sKeys.put(30, "replyingToUser");
      sKeys.put(31, "rightDrawable");
      sKeys.put(32, "rightString");
      sKeys.put(33, "rightStringActive");
      sKeys.put(34, "showFeedAction");
      sKeys.put(35, "showProgressBar");
      sKeys.put(36, "showReplying");
      sKeys.put(37, "showReplyingTo");
      sKeys.put(38, "showShareButton");
      sKeys.put(39, "showViewAllComment");
      sKeys.put(40, "showViewMoreRepliesButton");
      sKeys.put(41, "showViewRepliesButton");
      sKeys.put(42, "title");
      sKeys.put(43, "viewModel");
      sKeys.put(44, "vm");
      sKeys.put(45, "vmAudioMsg");
      sKeys.put(46, "vmImageMessage");
      sKeys.put(47, "vmTextMessage");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(0);
  }
}
