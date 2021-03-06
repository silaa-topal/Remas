package com.example.remasbackend.controller;


import com.example.remasbackend.exception.ResourceNotFoundException;
import com.company.remasbackend.model.receipt;
import com.company.remasbackend.model.Order;
import com.example.remasbackend.model.table;
import com.example.remasbackend.repository.receiptRepository;
import java.util.ArrayList;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Date;
@RestController
@RequestMapping("/api/v1/")
public class receiptController {
    @Autowired
    private receiptRepository receiptRepository;

    // get all tables
    @GetMapping("/receipts")
    public List<receipt> getAllReceipts(){
        return receiptRepository.findAll();}

    @PostMapping
    public receipt createReceipt(@RequestBody receipt Receipt){
        return receiptRepository.save(Receipt);
    }

    @GetMapping
    public ResponseEntity<receipt> getReceiptByID(@PathVariable Long id){
        receipt Receipt = receiptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receipt not exist with id : "+id));
        return ResponseEntity.ok(Receipt);
    }

    @PatchMapping("/tables")
    public void addOrderToReceipt(@PathVariable Long id, Order order){
        receipt added = receiptRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Receipt not exist with id : "+id));
        added.addOrder(order);
    }

    @PostMapping
    public List<receipt> getReceiptsLast30(){
        Calendar cal = Calendar.getInstance();
        Date cdate = cal.getTime();
        cal.add(Calendar.MONTH, -1);
        Date pdate = cal.getTime();
        List<receipt> all = getAllReceipts();
        
        List<receipt> send = new ArrayList<receipt>();
        for(int i =0;i<all.size();i++){
            if(all.get(i).dCreated().before(cdate)&&all.get(i).dCreated().after(pdate)){
                send.add(all.get(i));
            }
            
        }
        return send;
    }
    
    @PostMapping
    public List<receipt> getReceiptsLastYear(){
        Calendar cal = Calendar.getInstance();
        Date cdate = cal.getTime();
        cal.add(Calendar.YEAR, -1);
        Date pdate = cal.getTime();
        List<receipt> all = getAllReceipts();
        
        List<receipt> send = new ArrayList<receipt>();
        for(int i =0;i<all.size();i++){
            if(all.get(i).dCreated().before(cdate)&&all.get(i).dCreated().after(pdate)){
                send.add(all.get(i));
            }
            
        }
        return send;
    }
    @PostMapping
    public List<receipt> getReceiptsLastWeek(){
        Calendar cal = Calendar.getInstance();
        Date cdate = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date pdate = cal.getTime();
        List<receipt> all = getAllReceipts();
        
        List<receipt> send = new ArrayList<receipt>();
        for(int i =0;i<all.size();i++){
            if(all.get(i).dCreated().before(cdate)&&all.get(i).dCreated().after(pdate)){
                send.add(all.get(i));
            }
            
        }
        return send;
    }
}
