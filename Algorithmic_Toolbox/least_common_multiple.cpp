#include <iostream>

int gcd_fast(int a, int b) {
    int temp;
    if (a < b)
    {
        temp = a;
        a = b;
        b = temp;
    }
    while (a && b)
    {
        temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}

long long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long long)a * b; ++l)
        if (l % a == 0 && l % b == 0)
            return l;

    return (long long)a * b;
}

long long lcm_fast(int a, int b) {
    int c = gcd_fast(a, b);
    long long m = (long long)a * b;
    m = m / c;

    return m;
}

int main() {
    int a, b;
    std::cin >> a >> b;
    std::cout << lcm_fast(a, b) << std::endl;
    return 0;
}
