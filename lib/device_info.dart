import 'dart:async';
import 'package:flutter/services.dart';

class DeviceInfo {
  static const platform = MethodChannel('DeviceInfo');

  static Future<Map<String, String>?> getDeviceInfo() async {
    final Map<String, String>? deviceInfo = await platform.invokeMapMethod('getDeviceInfo');

    return deviceInfo;
  }
}