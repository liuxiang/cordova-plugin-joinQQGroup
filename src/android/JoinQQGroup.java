package com.wosai.joinQQGroup;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;

public class JoinQQGroup extends CordovaPlugin {

	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		boolean result = false;
		if ("open".equalsIgnoreCase(action)) {
		  JSONObject jsonObj = args.getJSONObject(0);
      String uin = jsonObj.getString("uin");
      String key = jsonObj.getString("key");
      result = joinQQGroup(key);
		}
		return result;
	}

	/****************
	 *
	 * 发起添加群流程。群号：创业吧(8182842) 的 key 为： yvRoU7uf56iSRPZHXJkqK9LBrDa_qcXr 调用
	 * joinQQGroup(yvRoU7uf56iSRPZHXJkqK9LBrDa_qcXr) 即可发起手Q客户端申请加群 创业吧(8182842)
	 *
	 * @param key
	 *            由官网生成的key
	 * @return 返回true表示呼起手Q成功，返回fals表示呼起失败
	 ******************/
	public boolean joinQQGroup(String key) {
		Intent intent = new Intent();
		intent.setData(Uri
				.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D"
						+ key));
		// 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面
		// intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
		try {
			cordova.getActivity().startActivity(intent);
			return true;
		} catch (Exception e) {
			// 未安装手Q或安装的版本不支持
			return false;
		}
	}

}
