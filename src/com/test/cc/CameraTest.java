package com.test.cc;

import com.hikvision.vmsnetsdk.CameraInfoEx;
import com.hikvision.vmsnetsdk.VMSNetSDK;

public class CameraTest {

	public static void main(String[] args) {
		System.loadLibrary("libMCRSDK");
		VMSNetSDK mVMSNetSDK = null;
		String CameraID="00000000001310016096";
		String ServerAddress="10.33.25.163:8000/msp";
		String SessionID="TGT-111-wvV7kHIbtABG7NFTnsCgoCRQkWKYXoRrlpAptnFE7uKh6lo2Xt-cas";
		CameraListItemData cameraListItemData = null;
        CameraInfoEx cameraInfoEx = new CameraInfoEx();
        cameraInfoEx.setId(CameraID);
        if (mVMSNetSDK == null) {
            mVMSNetSDK = VMSNetSDK.getInstance();
        }
        
        boolean temp = mVMSNetSDK.getCameraInfoEx(ServerAddress,SessionID, CameraID, cameraInfoEx);
        System.out.println("temp:  "+temp);
	}

}
