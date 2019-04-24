package ch.zhaw.vivi.webContext.domain.givenResponse.dto;

import ch.zhaw.vivi.config.generic.ExtendedDTO;
import ch.zhaw.vivi.webContext.domain.responseOption.dto.ResponseOptionDTO;

/**
 * DTO-class for the entity givenResponse.
 *
 *
 */
public class GivenResponseDTO extends ExtendedDTO {

    private ResponseOptionDTO responseOption;

    public ResponseOptionDTO getResponseOption() {
        return responseOption;
    }

    public void setResponseOption(ResponseOptionDTO responseOption) {
        this.responseOption = responseOption;
    }
}