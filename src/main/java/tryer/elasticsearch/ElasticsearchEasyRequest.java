package tryer.elasticsearch;


import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.ClusterName;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticsearchEasyRequest {

    public TransportClient transportClient() throws UnknownHostException {
        return new PreBuiltTransportClient(
                Settings.builder()
//                        .put("cluster.name", "my-application")
                        .put("client.transport.sniff", true)
                        .build()
        )
                .addTransportAddress(new TransportAddress(
                        InetAddress.getByName("127.0.0.1"), 9300));
    }

    public static void main(String[] args) throws UnknownHostException {
        TransportClient elasticsearch = new ElasticsearchEasyRequest().transportClient();

        final IndicesExistsResponse response = elasticsearch
                .admin()
                .indices()
                .prepareExists("whitelist")
                .get(TimeValue.timeValueMillis(100));

        System.out.println(response.isExists());


    }


}
