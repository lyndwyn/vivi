package ch.zhaw.vivi.webContext.domain.givenResponse;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOption;

import ch.zhaw.vivi.config.generic.ExtendedEntity;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "GivenResponse", description = "GivenResponse Entity")
@Entity
public class GivenResponse extends ExtendedEntity {
    @ManyToOne(optional = false)
    private ResponseOption responseOption;

    public GivenResponse() { }

    public GivenResponse(Long id){
        super(id);
    }

    public GivenResponse(ResponseOption responseOption) {
        this.responseOption = responseOption;
    }

    public GivenResponse(Long id, ResponseOption responseOption) {
        super(id);
        this.responseOption = responseOption;
    }

    public Integer calculateScore() {
        return responseOption.getCorrect() ? 1 : -1;
    }

    public ResponseOption getResponseOption() {
        return responseOption;
    }

    public void setResponseOption(ResponseOption responseOption) {
        this.responseOption = responseOption;
    }
}
