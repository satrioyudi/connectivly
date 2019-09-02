package com.weekendproject.connectivly.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.SalesOrder;


@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long>, JpaSpecificationExecutor<SalesOrder> {

	SalesOrder findByPoCode(String poNumber);

	Optional<SalesOrder> findByCode(String code);

	Page<SalesOrder> findAllByUserIdAndIsLinkedAndIsApproved(Pageable page, String string, String string2, boolean b);
	
	interface SalesOrderViewDetail{
		Long getSoId();
		Long getSopId();
		String getCode();
		String getPoCode();
		Date getSoDate();
		Integer getAvailable();
		Integer getQuantity();
		Double getPrice();
		Double getPercent();
		Double getTotal();
		String getName();
		String getBrands();
	}
	@Query(value = "select so.id as soId, so.code, so.po_code as poCode, so.so_date as soDate, "+
	"sop.id as sopId, sop.available_qty as available, sop.quantity, sop.price, sop.percent_1 as percent, sop.total, "+
	"p.name, m.brands from sales_order so "+
	"inner join sales_order_product sop "+
	"on so.id = sop.sales_order_id "+
	"inner join products p "+
	"on sop.product_id = p.id "+
	"inner join master m "+
	"on p.brand_id = m.id "+
	"where so.code = :code and so.user_id = :userId", nativeQuery = true)
	List<SalesOrderViewDetail> viewSalesOrderDetail(@Param("userId") String userId, @Param("code") String code);


}
