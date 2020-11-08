package carshare;

import carshare.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverShipped_Updatestatus(@Payload Shipped shipped){

        if(shipped.isMe()){
            System.out.println("##### listener Updatestatus : " + shipped.toJson());

            Optional<Order> orderOptional = orderRepository.findById(shipped.getOrderId());
            Order order = orderOptional.get();
            order.setStatus(shipped.getStatus());

            orderRepository.save(order);

        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOffered_Updatestatus(@Payload Offered offered){

        if(offered.isMe()){
            System.out.println("##### listener Updatestatus : " + offered.toJson());
            Optional<Order> orderOptional = orderRepository.findById(offered.getOrderId());
            Order order = orderOptional.get();
            order.setStatus(offered.getStatus());

            orderRepository.save(order);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPointCanceled_Updatestatus(@Payload PointCanceled pointCanceled){

        if(pointCanceled.isMe()){
            System.out.println("##### listener Updatestatus : " + pointCanceled.toJson());
            Optional<Order> orderOptional = orderRepository.findById(pointCanceled.getOrderId());
            Order order = orderOptional.get();
            order.setStatus(pointCanceled.getStatus());

            orderRepository.save(order);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCanceled_Updatestatus(@Payload DeliveryCanceled deliveryCanceled){

        if(deliveryCanceled.isMe()){
            System.out.println("##### listener Updatestatus : " + deliveryCanceled.toJson());
            Optional<Order> orderOptional = orderRepository.findById(deliveryCanceled.getOrderId());
            Order order = orderOptional.get();
            order.setStatus(deliveryCanceled.getStatus());

            orderRepository.save(order);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_Updatestatus(@Payload Paid paid){

        if(paid.isMe()){
            System.out.println("##### listener Updatestatus : " + paid.toJson());
            Optional<Order> orderOptional = orderRepository.findById(paid.getOrderId());
            Order order = orderOptional.get();
            order.setStatus(paid.getStatus());

            orderRepository.save(order);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCancelled_Updatestatus(@Payload PayCancelled payCancelled){

        if(payCancelled.isMe()){
            System.out.println("##### listener Updatestatus : " + payCancelled.toJson());
            Optional<Order> orderOptional = orderRepository.findById(payCancelled.getOrderId());
            Order order = orderOptional.get();
            order.setStatus(payCancelled.getStatus());

            orderRepository.save(order);
        }
    }

}
