package com.weekendproject.connectivly.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.GoodReceivedNotes;


@Repository
public interface GoodReceivedNotesRepository extends JpaRepository<GoodReceivedNotes, Long>, JpaSpecificationExecutor<GoodReceivedNotes> {

	Page<GoodReceivedNotes> findAllByUserId(Pageable page, String decodeJwt);

	GoodReceivedNotes findByCode(String code);
	
	interface GrnPoProduct2 {
		Long getId();
		String getPoNumber();
		Double getSellingPrice();
		Integer getQuantity();
		Integer getRealQty();
		Double getPrice();
		Double getPercent1();
		Double getTotal();
		Double getSellingPercent();
		String getBrands();
		String getName();
		String getImage();
	}
	
	@Query(value = "select grn.id, gpp.po_number as poNumber, gpp.selling_price as sellingPrice, gpp.quantity, gpp.real_qty as realQty, "+
	"gpp.price, gpp.percent1, gpp.total, gpp.selling_percent as sellingPercent, "+
    "m.brands, p.name, p.image "+
	"from good_received_notes grn "+
	"left join grn_po_product gpp on gpp.good_received_note_id = grn.id "+
    "inner join products p on p.id = gpp.product_id "+
    "inner join master m on m.id = gpp.brand_id "+
	"where grn.code = :code", nativeQuery = true)
	List<GrnPoProduct2> findGrnPoProductByCode(@Param("code") String code);

}
