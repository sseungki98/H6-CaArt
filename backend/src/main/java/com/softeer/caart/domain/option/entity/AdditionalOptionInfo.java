package com.softeer.caart.domain.option.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.softeer.caart.domain.option.exception.InvalidOptionException;
import com.softeer.caart.global.ResultCode;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "additional_option_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdditionalOptionInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "additional_option_info_id")
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "base_option_info_id", nullable = false)
	private BaseOptionInfo details;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Boolean isSetOption = false;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Badge badge;

	@Column(nullable = false)
	private String summary;

	@Embedded
	private Position position;

	@OneToMany(mappedBy = "superOption")
	private List<SubOptionInfo> subOptions = new ArrayList<>();

	@Builder
	public AdditionalOptionInfo(BaseOptionInfo details, Integer price, Boolean isSetOption, Badge badge, String summary,
		Position position, List<SubOptionInfo> subOptions) {
		this.details = details;
		this.price = price;
		this.isSetOption = isSetOption;
		this.badge = badge;
		this.summary = summary;
		this.position = position;
		this.subOptions = subOptions;
	}

	public boolean isOptionTypeSet() {
		return this.isSetOption;
	}

	public void validateAdditionalOption() {
		if (details.isOptionTypeBasic()) {
			throw new InvalidOptionException(ResultCode.INVALID_ADDITIONAL_OPTION);
		}
	}
}
