
declare function emptyVector(): Array<Number>;
declare function addVector(v : Array<Number>, ...e : number): Array<Number>;

interface StringStack {
    push(item : String): void;
    pop(): String;
    lengths(): number[];
    name: String;
    next: StringStack;
}

interface StringStackConstructor {
    new (next? : StringStack): StringStack;
}

declare StringStack : StringStackConstructor;

interface Attr {
}
declare var Attr: {
    prototype: Attr;
    new(): Attr;
}
declare var attr: Attr;
declare var AttrValue: number;
declare var AttrValueInitialized: number;
declare var UnionInitialized: number | boolean | string;

interface Get<T> {
    (x: T, y: T): T;
}

interface SingletonNumber {
    value: Get<Number>;
}
declare var singletonNumber: SingletonNumber;

interface FirstValue {
    <T>(value?: T): Get<T>;;
}
declare var firstValue: FirstValue;
