import 'package:flutter/material.dart';
import 'package:deviceinfo/device_info.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  
  // Get device info
  await DeviceInfo.getDeviceInfo();
}
