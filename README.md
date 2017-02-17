# HttpUtils
HttpUtils Asynchronous and synchronous get post file uploads

How to use:
Upload File

```java
      HttpUtils.doPostFileAsyn(new File(SDCardUtils.getSDCardPath() + "test1.jpg"),
                "http://172.16.100.106:8080/UploadFile.ashx",
                new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(final String result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
```
                
