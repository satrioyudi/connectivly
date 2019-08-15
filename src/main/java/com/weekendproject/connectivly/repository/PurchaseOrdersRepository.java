package com.weekendproject.connectivly.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.PurchaseOrders;


@Repository
public interface PurchaseOrdersRepository extends JpaRepository<PurchaseOrders, Long>, JpaSpecificationExecutor<PurchaseOrders> {

	Page<PurchaseOrders> findAllByUserId(Long userId, Pageable pageRequest);

	PurchaseOrders findByPoNumber(String poNumber);

	interface PurchaseOrderView{
		Integer getId();
		Boolean getIsApproved();
		Date getPoDate();
		Date getApprovedAt();
		String getPoNumber();
	    String getUserId();
	    String getSupplier();
	}
	
	@Query(value = "select po.id, po.is_approved, po.po_date as poDate, po.po_number as poNumber, po.user_id as userId, po.supplier_id as supplier, po.approved_at as approvedAt "+
            "from purchase_orders po "+
            "inner join product_purchase_order ppo on po.id = ppo.purchase_order_id "+ 
            "where ppo.deleted_at is null and po.user_id = :userId and po.supplier_id = :supplierId and po.is_approved = false "+
            "group by po.id, po.po_number, po.po_date, po.user_id, po.supplier_id, po.approved_at", nativeQuery = true)
			
	Page<PurchaseOrderView> getAllPurchaseOrder(Pageable page, @Param("userId") String userId, @Param("supplierId") int supplierId);
			
	
	interface PurchaseOrderViewDetail{
		Long getId();
		Date getDeleteAt();
		Long getProductId();
		Long getPurcahseOrderId();
		Integer getQuantity();
		Integer getQuantityLeft();
		String getStatus();
		Date getPoDate();
		String getPoNumber();
	    String getUserId();
	    String getCode();
	    String getImage();
	    String getName();
	    String getPrice();
	    Integer getQty();
	    Integer getQtyBox();
	    Integer getPriceBefore();
	    Integer getItemCost();
	    Integer getItemCostBefore();
	    Integer getPrevItemCost();
	    Integer getItemCostRaw();
	    String getItemCategory();
	    String getBrands();
	    String getMeasurements();
	}
	
	@Query(value = "select ppo.id, ppo.deleted_at as deleteAt, ppo.product_id as productId, ppo.purchase_order_id as purcahseOrderId, ppo.quantity, ppo.quantity_left as quantityLeft, "+ 
			"(case when po.is_approved = true then 'Approved' else 'Pending' end) as status, po.po_date as poDate, po.po_number as poNumber, po.user_id as userId, "+
			"p.code, p.image, p.name, p.price, p.qty, p.qty_box as qtyBox, p.price_before as priceBefore, p.item_cost as itemCost, p.item_cost_before as itemCostBefore, "+
			"p.prev_item_cost as prevItemCost, p.item_cost_raw as itemCostRaw, "+
			"mstr.itemCategory, mstr2.brands, mstr3.measurements "+
			"FROM product_purchase_order ppo "+
			"left join purchase_orders po on po.id = ppo.purchase_order_id "+
			"inner join products p on p.id = ppo.product_id "+
            "inner join ( "+
				"select "+
                "m.id as id, "+
				"m.item_category as itemCategory "+
					"from master m "+
				"left join products p on p.brand_id = m.id and p.item_category_id = m.id "+
				 "and p.measurement_id = m.id "+
			") mstr "+
            "on mstr.id = p.item_category_id "+
            "inner join ( "+
				"select "+ 
                "m.id as id, "+
				"m.brands as brands "+
					"from master m "+
				"left join products p on p.brand_id = m.id and p.item_category_id = m.id "+
				 "and p.measurement_id = m.id "+
			") mstr2 "+
            "on mstr2.id = p.brand_id "+
            "inner join ( "+
				"select "+ 
                "m.id as id, "+
				"m.measurements as measurements "+
					"from master m "+
				"left join products p on p.brand_id = m.id and p.item_category_id = m.id "+
				 "and p.measurement_id = m.id "+
			") mstr3 "+
            "on mstr3.id = p.measurement_id "+
			"where ppo.user_id = :userId and po.po_number = :poNumber and ppo.deleted_at is null "+
			"order by po_number", nativeQuery = true)
	
	List<PurchaseOrderViewDetail> viewPurchaseOrderDetail(@Param("userId") String userId, @Param("poNumber") String poNumber);

	List<PurchaseOrders> findAllByIsApprovedTrueAndUserId(String decodeJwt);

	

}
