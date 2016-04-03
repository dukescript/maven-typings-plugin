

declare function compose<A,B,C>(f : (v : A) => B, g : (v : B) => C) : (A) => C;

var fn : {
  (): string;
  (x: number): string;
  fourtyTwo: number;
};

interface FnT {
  (): string;
  (x: number): string;
  fourtyTwo: number;
  rec: FnT;
  first(x: number, name?: string): number;
  first(y: number, count?: number): number;
  first(z: string, name?: string): string;
}
var fnT : FnT;

interface Rev {
    reverse: <T>(arr: Array<T>) => Array<T>;
    notify(x?: number): number;
}
var rev: Rev;

interface Literal {
    (name: 'number'): number;
    (name: 'boolean'): boolean;
    (name: string): boolean;
    tripple: [number, string, boolean];
}
var literal: Literal;


interface IScope {
    $compute<T>(callback : (scope: IScope) => T): T;
}
var scope: IScope;
        
interface Watch {
    $watch(watchExpression: (scope: IScope) => any, listener?: string): Function;
    $watch<T>(watchExpression: (scope: IScope) => T, listener?: (newValue: T, oldValue: T, scope: IScope) => any): Function;
}

declare function tripple(): [number, string, boolean];
