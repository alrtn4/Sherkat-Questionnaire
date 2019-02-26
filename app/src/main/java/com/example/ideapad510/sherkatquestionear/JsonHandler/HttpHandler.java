package com.example.ideapad510.sherkatquestionear.JsonHandler;

import android.os.AsyncTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler {

    String TAG = "httphandler";

    public String sendHttpRequest(String url, String jsonTxt) {


        StringBuffer buffer = new StringBuffer();
        HttpURLConnection con = null;

        try {
             con = (HttpURLConnection) (new URL(url)).openConnection();
            con.setRequestMethod("POST");
//            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            con.getOutputStream().write((jsonTxt).getBytes());


            InputStream is = con.getInputStream();
            byte[] b = new byte[1024];
            while (is.read(b) != -1)
                buffer.append(new String(b));
            con.disconnect();
        } catch (Exception e) {
            System.out.println( "errorrrrrrrrr "+e);
        }


        return buffer.toString();
    }

/*
    public String sendHttpRequest2(String uRL, String jsonTxt){

        StringBuffer buffer = new StringBuffer();

        try {
            //constants
            URL url = new URL(uRL);
//            String yourJsonString = object.toString();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setFixedLengthStreamingMode(jsonTxt.getBytes().length);

            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            conn.connect();

            OutputStream os = new BufferedOutputStream(conn.getOutputStream());
            os.write(jsonTxt.getBytes());

            os.flush();

            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            while ( is.read(b) != -1)
                buffer.append(new String(b));


            //clean up
            os.close();
            is.close();
            conn.disconnect();


        } catch (Exception e){

        } finally {
        }


        return  buffer.toString();

    }



    public String sendHttpRequest3(String url, String jsonTxt) {


        StringBuffer buffer = new StringBuffer();


        try {
            HttpURLConnection con = (HttpURLConnection) (new URL(url)).openConnection();
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

//            con.getOutputStream().write((jsonTxt).getBytes());


            InputStream is = con.getInputStream();
            byte[] b = new byte[1024];
            while (is.read(b) != -1)
                buffer.append(new String(b));
            con.disconnect();
        } catch (Exception e) {
        }


        return buffer.toString();
    }



    public String sendHttpRequest4(String urL, String json){

        StringBuilder sb = new StringBuilder();
//        HttpURLConnection client = null;
        HttpURLConnection client;

        try {
            URL url = new URL(urL);
            client = (HttpURLConnection) url.openConnection();
            Log.d(TAG, "sendHttpRequest4: "+(client == null));
            client.setDoOutput(true);
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestProperty("Authorization", "Basic " + Base64.encodeToString("userid:pwd".getBytes(), Base64.NO_WRAP));
            client.setRequestMethod("GET");

            client.connect();

            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
            String output = json.toString();
            writer.write(output);
            writer.flush();
            writer.close();

            int HttpResult = client.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        client.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                client.disconnect();
            }
        } catch (IOException e) {
//            this.e = e;

            Log.d(TAG, "sendHttpRequest4: "+e);
        } finally {
//            client.disconnect();
        }

        return sb.toString();

    }





    public InputStream OpenHttpConnection(String urlString)
            throws IOException
    {
        InputStream in = null;
        int response = -1;

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not an HTTP connection");
        try{
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        }
        catch (Exception ex)
        {
            throw new IOException("Error connecting");
        }
        return in;
    }


    static Document doc;


    private ArrayList<String> WordDefinition(String word) {
        InputStream in = null;
        ArrayList<String> titles = new ArrayList<String>();
        try {
            in = OpenHttpConnection(word);
            doc = null;
            DocumentBuilderFactory dbf =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder db;
            try {
                db = dbf.newDocumentBuilder();
                doc = db.parse(in);
            } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//            doc.getDocumentElement().normalize();


/*            //---retrieve all the <Definition> elements---
            NodeList definitionElements =
                    doc.getElementsByTagName("rss");

            //---iterate through each <Definition> elements---
            for (int i = 0; i < definitionElements.getLength(); i++) {
                Node itemNode = definitionElements.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    //---convert the Definition node into an Element---
                    Element definitionElement = (Element) itemNode;

                    //---get all the <WordDefinition> elements under
                    // the <Definition> element---
                    NodeList wordDefinitionElements =
                            (definitionElement).getElementsByTagName(
                                    "title");

                    //---iterate through each <WordDefinition> elements---
                    for (int j = 0; j < wordDefinitionElements.getLength(); j++) {
                        //---convert a <WordDefinition> node into an Element---
                        Element wordDefinitionElement =
                                (Element) wordDefinitionElements.item(j);

                        //---get all the child nodes under the
                        // <WordDefinition> element---
                        NodeList textNodes =
                                ((Node) wordDefinitionElement).getChildNodes();

                        titles.add(((Node) textNodes.item(0)).getNodeValue() + ". \n");
//                        strings.add(((Node) textNodes.item(0)).getNodeValue() + ". \n");
                    }

                }
            }
*//*        } catch (IOException e1) {
            Log.d("NetworkingActivity", e1.getLocalizedMessage());
        }
        return titles;
    }


*/


    private class SendHttpRequestTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String url = params[0];
            String jsonTxt = params[1];
            String data = sendHttpRequest(url, jsonTxt);
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            System.out.println("RESULTTTTTTTTT    "+result);
        }
    }




    public void start(String url, String jsonTxt){
        SendHttpRequestTask sendHttpRequestTask = new SendHttpRequestTask();
        sendHttpRequestTask.execute(url,jsonTxt);
    }


/*
    public static String sendjson() {
        JSONText jsonText = new JSONText();
        String responseAsString = new String();
        try {
            StringEntity se = new StringEntity(jsonText.getText());
        HttpPost httpost =new HttpPost("http://www.jmr.samim.org/JMR-Q/req-app/send-results.php?req=1");
        httpost.setEntity(se);
        httpost.setHeader("Accept", "application/json");
        httpost.setHeader("Content-type", "application/json");
        HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httpost);
            responseAsString = EntityUtils.toString(response.getEntity());
        }catch(Exception e){
            System.out.println("errorrrrrrrrrrrrr  "+e);
        }

        System.out.println("ddddddddddddd  "+(responseAsString==null));
        return responseAsString;
    }
*/

}
