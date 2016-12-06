/**
 *    Copyright 2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package examples.animal.data;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.qbe.sql.delete.DeleteSupport;
import org.mybatis.qbe.sql.insert.InsertSupport;
import org.mybatis.qbe.sql.select.SelectSupport;
import org.mybatis.qbe.sql.update.UpdateSupport;

public interface AnimalDataMapper {

    @Select({
        "select ${distinct} a.id, a.animal_name as animalName, a.brain_weight as brainWeight, a.body_weight as bodyWeight",
        "from AnimalData a",
        "${whereClause}",
        "${orderByClause}"
    })
    List<AnimalData> selectByExample(SelectSupport selectSupport);

    @Delete({
        "delete from AnimalData",
        "${whereClause}"
    })
    int deleteByExample(DeleteSupport deleteSupport);

    @Update({
        "update AnimalData",
        "${setClause}",
        "${whereClause}"
    })
    int updateByExample(UpdateSupport updateSupport);
    
    @Insert({
        "insert into AnimalData",
        "${fieldsPhrase}",
        "${valuesPhrase}"
    })
    int insert(InsertSupport<AnimalData> insertSupport);
}