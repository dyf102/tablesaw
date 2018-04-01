/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.tablesaw.api;

import tech.tablesaw.columns.booleans.BooleanColumnReference;
import tech.tablesaw.columns.dates.DateColumnReference;
import tech.tablesaw.columns.datetimes.DateTimeColumnReference;
import tech.tablesaw.columns.number.NumberColumnReference;
import tech.tablesaw.columns.string.StringColumnReference;
import tech.tablesaw.columns.times.TimeColumnReference;
import tech.tablesaw.filtering.Filter;
import tech.tablesaw.filtering.composite.AllOf;
import tech.tablesaw.filtering.composite.AnyOf;
import tech.tablesaw.filtering.composite.IsFalse;

import java.util.ArrayList;
import java.util.List;

/**
 * A static utility class designed to take some of the work, and verbosity, out of making queries.
 * <p>
 * It is intended to be imported statically in any class that will run queries as it makes them easier to write - and
 * read.
 */
public class QueryHelper {

    /**
     * Returns a column reference for a Stringolumn with the given name. It will be resolved at query time by associating
     * it with a table. At construction time, the columnType is unknown, so the user has to pick the
     * correct type.
     */
    public static StringColumnReference stringColumn(String columnName) {
        return new StringColumnReference(columnName);
    }

    public static TimeColumnReference timeColumn(String columnName) {
        return new TimeColumnReference(columnName);
    }

    public static DateColumnReference dateColumn(String columnName) {
        return new DateColumnReference(columnName);
    }

    public static DateTimeColumnReference dateTimeColumn(String columnName) {
        return new DateTimeColumnReference(columnName);
    }

    public static NumberColumnReference numberColumn(String columnName) {
        return new NumberColumnReference(columnName);
    }

    public static BooleanColumnReference booleanColumn(String columnName) {
        return new BooleanColumnReference(columnName);
    }

    public static Filter both(Filter a, Filter b) {
        List<Filter> filterList = new ArrayList<>();
        filterList.add(a);
        filterList.add(b);
        return AllOf.allOf(filterList);
    }

    public static Filter allOf(Filter... filters) {
        return AllOf.allOf(filters);
    }

    public static Filter and(Filter... filters) {
        return AllOf.allOf(filters);
    }

    public static Filter not(Filter filter) {
        return IsFalse.isFalse(filter);
    }

    public static Filter either(Filter a, Filter b) {
        List<Filter> filterList = new ArrayList<>();
        filterList.add(a);
        filterList.add(b);
        return AnyOf.anyOf(filterList);
    }

    public static Filter anyOf(Filter... filters) {
        return AnyOf.anyOf(filters);
    }

    public static Filter or(Filter... filters) {
        return AnyOf.anyOf(filters);
    }
}
