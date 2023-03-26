package model;

import java.util.List;

public interface iGungunDao {
	List<GugunDto> selectGugunBySido(int sideCode);
}
