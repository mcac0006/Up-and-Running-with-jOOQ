package com.classicmodels.repository;

import com.classicmodels.model.ProductLine;
import java.util.List;
import static jooq.generated.tables.Productline.PRODUCTLINE;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ClassicModelsRepositoryImpl implements ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepositoryImpl(DSLContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<ProductLine> findProductLineJooq() {
        return ctx.selectFrom(PRODUCTLINE)
                .fetchInto(ProductLine.class);
    }

    @Override
    @Transactional
    public void updateProductLineDescriptionJooq() {

        ctx.update(PRODUCTLINE)
                .set(PRODUCTLINE.TEXT_DESCRIPTION, "Classic cars are so cool (jOOQ as well)!")
                .where(PRODUCTLINE.PRODUCT_LINE.eq("Classic Cars"))
                .execute();
    }
}