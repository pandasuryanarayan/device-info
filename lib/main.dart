import 'package:flutter/material.dart';
import 'package:deviceinfo/device_info.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Get device info
  final deviceinfo = await DeviceInfo.getDeviceInfo();

  // Print device info
  print(deviceinfo);
  print(deviceinfo!['device_id']);
  print(deviceinfo['device_brand']);
  print(deviceinfo['device_model']);
  print(deviceinfo['device_version']);
  print(deviceinfo['build_id']);
}
