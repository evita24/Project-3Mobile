package com.example.usingpreferences.DataModel;
import android.content.Context;
import com.example.usingpreferences.DataModel.DataShared;
import com.example.usingpreferences.DataModel.DataShared.KEY;
import com.example.usingpreferences.DataModel.VerifyModel;

//import com.c2.arenafinder.data.local.DataShared;
//import com.c2.arenafinder.data.local.DataShared.KEY;
//import com.c2.arenafinder.data.local.LogApp;
//import com.c2.arenafinder.data.local.LogTag;
//import com.c2.arenafinder.data.model.VerifyModel;

import java.util.HashMap;
import java.util.Objects;
public class VerifyUtil {
    public static final String TYPE_SIGNUP = "SignUp";

    public static final String TYPE_FORGOT = "ForgotPass";

    public static final String ACTION_NEW = "new";

    public static final String ACTION_UPDATE = "update";

    public static int _15_MINUTES = 900_000;

    private static final String NULL = "null";

    private static final int minutes = 60;

    private final Context context;

    private final DataShared dataShared;

    public VerifyUtil(Context context, VerifyModel model){
        this.context = context;
        dataShared = new DataShared(context);

        if (model != null){
            setEmail(model.getEmail());
            setOtp(model.getOtp());
            setDevice(model.getDevice());
        }
    }

    public VerifyUtil(Context context) {
        this(context, null);
    }

    private String getData(KEY key) {
        if (dataShared.contains(key)) {
            String data = dataShared.getData(key);
            if (data != null && !data.isEmpty()) {
                return data;
            }
            return NULL;
        }
        return NULL;
    }

    public String getEmail(){
        return getData(KEY.VERIFY_EMAIL);
    }

    public void setEmail(String email){
        dataShared.setData(KEY.VERIFY_EMAIL, email);
    }

    public String getOtp() {
        return getData(KEY.VERIFY_OTP_CODE);
    }

    public void setOtp(String otp) {
        dataShared.setData(KEY.VERIFY_OTP_CODE, otp);
    }

    public String getType() {
        return getData(KEY.VERIFY_TYPE);
    }

    public void setType(String type) {
        dataShared.setData(KEY.VERIFY_TYPE, type);
    }

    public String getDevice() {
        return getData(KEY.VERIFY_DEVICE);
    }

    public void setDevice(String device) {
        dataShared.setData(KEY.VERIFY_DEVICE, device);
    }

    public void setResend(int type) {
        dataShared.setData(KEY.VERIFY_RESEND, String.valueOf(type));
    }

    public int getResend() {
        try{
            return Integer.parseInt(getData(KEY.VERIFY_RESEND));
        }catch (Throwable ex){
            ex.printStackTrace();
        }
        return 1;
    }



    public String getCreated(){
        return getData(KEY.VERIFY_CREATED);
    }

    public void setCreated(String created){
        dataShared.setData(KEY.VERIFY_CREATED, created);
    }

    public boolean haveOtp() {
        // cek semua key pada verify exist atau tidak dalam preferences
        boolean have =
                dataShared.contains(KEY.VERIFY_EMAIL) && dataShared.contains(KEY.VERIFY_CREATED) &&
                        dataShared.contains(KEY.VERIFY_OTP_CODE) && dataShared.contains(KEY.VERIFY_START_MILLIS) &&
                        dataShared.contains(KEY.VERIFY_END_MILLIS) && dataShared.contains(KEY.VERIFY_TYPE) &&
                        dataShared.contains(KEY.VERIFY_DEVICE) && dataShared.contains(KEY.VERIFY_RESEND);

        // jika semua key exist
        if (have) {
            // mendapatkan semua data verify pada preferences
            HashMap<KEY, String> hash = dataShared.getData(
                    KEY.VERIFY_EMAIL, KEY.VERIFY_CREATED,
                    KEY.VERIFY_OTP_CODE, KEY.VERIFY_START_MILLIS, KEY.VERIFY_END_MILLIS,
                    KEY.VERIFY_TYPE, KEY.VERIFY_DEVICE, KEY.VERIFY_RESEND
            );

            // cek apakah data verify null atau tidak
            for (KEY key : hash.keySet()) {
                String data = hash.get(key);
                if (data == null || data.isEmpty()  || data.contains(NULL)) {
                    return false;
                }
            }

            // cek apakah otp masih berlaku atau tidak
            try {
                return Long.parseLong(Objects.requireNonNull(hash.get(KEY.VERIFY_END_MILLIS)))
                        >
                        System.currentTimeMillis();
            } catch (Throwable t) {
                t.printStackTrace();
            }

        }
        return false;
    }

    // TODO : 2 -> 3 -> 5 -> 7 -> 9 -> 11

    public void removeOtp(){
        dataShared.setNullData(KEY.VERIFY_OTP_CODE);
        dataShared.setNullData(KEY.VERIFY_EMAIL);
        dataShared.setNullData(KEY.VERIFY_START_MILLIS);
        dataShared.setNullData(KEY.VERIFY_END_MILLIS);
        dataShared.setNullData(KEY.VERIFY_RESEND);
        dataShared.setNullData(KEY.VERIFY_TYPE);
        dataShared.setNullData(KEY.VERIFY_DEVICE);
        dataShared.setNullData(KEY.VERIFY_CREATED);
    }
}
