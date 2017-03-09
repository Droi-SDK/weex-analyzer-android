package com.taobao.weex.analyzer.core;

import android.app.AlertDialog;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowAlertDialog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

/**
 * Description:
 *
 * Created by rowandjj(chuyi)<br/>
 */
@RunWith(RobolectricTestRunner.class)
public class JSExceptionCatcherTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void catchException() throws Exception {
        String fakeErrCode = "fake_error_code";
        String fakeMsg = "fake_msg";
        AlertDialog dialog = JSExceptionCatcher.catchException(RuntimeEnvironment.application,null,fakeErrCode,fakeMsg);

        assertNotNull(dialog);
        ShadowAlertDialog shadowAlertDialog = shadowOf(dialog);
        assertEquals(dialog.isShowing(),true);
        assertEquals(ShadowAlertDialog.getLatestAlertDialog(),dialog);

        assertEquals("wx-analyzer found a JS Exception",shadowAlertDialog.getTitle());
    }

}