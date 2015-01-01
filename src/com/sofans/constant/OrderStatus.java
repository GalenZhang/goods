package com.sofans.constant;

public enum OrderStatus {
	/*
	 * 如果是货到付款， 直接到preparing, 反之，待付款。
	 * */
	WAITINGFORPAY/*待付款*/, PREPARING/*准备出库*/, SENDING/*运输中*/, FINISHed, USE_LESS/*作废*/
}
