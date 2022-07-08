import { Health } from '../health.model';
import { DataSource } from '@angular/cdk/collections';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { map } from 'rxjs/operators';
import { Observable, of as observableOf, merge } from 'rxjs';

const EXAMPLE_DATA: Health[] = [
  {id: 1, description: 'Hydrogen'},
  {id: 2, description: 'Helium'},
  {id: 3, description: 'Lithium'},
  {id: 4, description: 'Beryllium'},
  {id: 5, description: 'Boron'},
  {id: 6, description: 'Carbon'},
  {id: 7, description: 'Nitrogen'},
  {id: 8, description: 'Oxygen'},
  {id: 9, description: 'Fluorine'},
  {id: 10, description: 'Neon'},
  {id: 11, description: 'Sodium'},
  {id: 12, description: 'Magnesium'},
  {id: 13, description: 'Aluminum'},
  {id: 14, description: 'Silicon'},
  {id: 15, description: 'Phosphorus'},
  {id: 16, description: 'Sulfur'},
  {id: 17, description: 'Chlorine'},
  {id: 18, description: 'Argon'},
  {id: 19, description: 'Potassium'},
  {id: 20, description: 'Calcium'},
];

/**
 * Data source for the HealthRead2 view. This class should
 * encapsulate all logic for fetching and manipulating the displayed data
 * (including sorting, pagination, and filtering).
 */
export class HealthRead2DataSource extends DataSource<Health> {
  data: Health[] = EXAMPLE_DATA;
  paginator: MatPaginator | any;
  sort: MatSort | any;

  constructor() {
    super();
  }

  /**
   * Connect this data source to the table. The table will only update when
   * the returned stream emits new items.
   * @returns A stream of the items to be rendered.
   */
  connect(): Observable<Health[]> {
    // Combine everything that affects the rendered data into one update
    // stream for the data-table to consume.
    const dataMutations = [
      observableOf(this.data),
      this.paginator.page,
      this.sort.sortChange
    ];

    return merge(...dataMutations).pipe(map(() => {
      return this.getPagedData(this.getSortedData([...this.data]));
    }));
  }

  /**
   *  Called when the table is being destroyed. Use this function, to clean up
   * any open connections or free any held resources that were set up during connect.
   */
  disconnect() {}

  /**
   * Paginate the data (client-side). If you're using server-side pagination,
   * this would be replaced by requesting the appropriate data from the server.
   */
  private getPagedData(data: Health[]) {
    const startIndex = this.paginator.pageIndex * this.paginator.pageSize;
    return data.splice(startIndex, this.paginator.pageSize);
  }

  /**
   * Sort the data (client-side). If you're using server-side sorting,
   * this would be replaced by requesting the appropriate data from the server.
   */
  private getSortedData(data: Health[]) {
    if (!this.sort.active || this.sort.direction === '') {
      return data;
    }

    return data.sort((a, b) => {
      const isAsc = this.sort.direction === 'asc';
      switch (this.sort.active) {
        case 'description': return compare(a.description, b.description, isAsc);
        case 'id': return compare(+a.id, +b.id, isAsc);
        default: return 0;
      }
    });
  }
}

/** Simple sort comparator for example ID/Name columns (for client-side sorting). */
function compare(a: string | number, b: string | number, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
