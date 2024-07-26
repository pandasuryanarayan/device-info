package com.surya.deviceinfo

import android.content.Context
import android.os.Build
import android.provider.Settings
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

class DeviceInfoPlugin : FlutterPlugin, MethodCallHandler {
  private lateinit var context: Context
  private lateinit var channel: MethodChannel

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == "getDeviceInfo") {
      val deviceId = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
      val deviceBrand = Build.MANUFACTURER
      val deviceModel = Build.MODEL
      val deviceVersion = Build.VERSION.RELEASE
      val buildId = Build.ID

      result.success(mapOf(
        "device_id" to deviceId,
        "device_brand" to deviceBrand,
        "device_model" to deviceModel,
        "device_version" to deviceVersion,
        "build_id" to buildId
      ))
    } else {
      result.notImplemented()
    }
  }

  override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    context = binding.applicationContext
    channel = MethodChannel(binding.binaryMessenger, "DeviceInfo")
    channel.setMethodCallHandler(this)
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
