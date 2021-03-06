/**
 * Copyright (c) www.bugull.com
 */
package cn.bit.hao.ble.tool.response.events.bluetooth;

import android.bluetooth.BluetoothDevice;

import cn.bit.hao.ble.tool.bluetooth.utils.ScanRecordCompat;
import cn.bit.hao.ble.tool.response.events.CommonEvent;
import cn.bit.hao.ble.tool.util.ByteBitUtil;

/**
 * @author wuhao on 2016/8/4
 */
public class BluetoothLeScanResultEvent extends CommonEvent {
	private static final String TAG = BluetoothLeScanResultEvent.class.getSimpleName();

	private BluetoothDevice device;
	private int rssi;
	private ScanRecordCompat scanRecord;

	public BluetoothLeScanResultEvent(BluetoothDevice device, int rssi, ScanRecordCompat scanRecord) {
		this.device = device;
		this.rssi = rssi;
		this.scanRecord = scanRecord;
	}

	public ScanRecordCompat getScanRecord() {
		return scanRecord;
	}

	public BluetoothDevice getDevice() {
		return device;
	}

	public int getRssi() {
		return rssi;
	}

	@Override
	public BluetoothLeScanResultEvent clone() {
		BluetoothLeScanResultEvent result = null;
		try {
			result = (BluetoothLeScanResultEvent) super.clone();
			result.scanRecord = this.scanRecord == null ? null : this.scanRecord.deepClone();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BluetoothLeScanResultEvent  ").append("device: ").append(device).append(", ")
				.append("rssi: ").append(rssi).append(", ").append("scanRecord: ")
				.append(ByteBitUtil.byteArrayToHexString(scanRecord.getBytes()))
				.append("\n").append(scanRecord);
		return sb.toString();
	}
}
