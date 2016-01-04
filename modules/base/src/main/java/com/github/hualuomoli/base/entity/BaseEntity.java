package com.github.hualuomoli.base.entity;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.github.hualuomoli.base.Pagination;
import com.github.hualuomoli.base.Paginator;
import com.github.hualuomoli.base.constant.Status;

/**
 * base entity implements Paginator and define common attribute
 * @author hualuomoli
 *
 */
public abstract class BaseEntity extends CommonField implements Paginator {

	private Pagination pagination; // pagination

	public BaseEntity() {
	}

	public final String getCurrentUser() {
		// TODO
		return "system";
	}

	public final Date getCurrentDate() {
		// TODO
		return new Date();
	}

	public void preInsert() {
		String currentUser = getCurrentUser();
		Date currentDate = getCurrentDate();

		setCreateBy(currentUser);
		setCreateDate(currentDate);
		setUpdateBy(currentUser);
		setUpdateDate(currentDate);
		setStatus(getStatus() == null ? Status.NORMAL : getStatus());
		setVersion(1);
		setId(StringUtils.isEmpty(getId()) ? UUID.randomUUID().toString().replaceAll("-", "") : getId());
	}

	public void preUpdate() {
		setUpdateBy(getCurrentUser());
		setUpdateDate(getCurrentDate());
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
