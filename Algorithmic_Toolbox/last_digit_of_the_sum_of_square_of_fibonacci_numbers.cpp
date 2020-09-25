#include <iostream>

int fibonacci_sum_squares_naive(long long n) {
    if (n <= 1)
        return n;

    long long previous = 0;
    long long current = 1;
    long long sum = 1;

    for (long long i = 0; i < n - 1; ++i) {
        long long tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
        sum += current * current;
    }

    return sum % 10;
}

int fibonacci_sum_squares_fast(long long n)
{
    if (n <= 1)
        return n;

    long long current = 1;
    long long previous = 0;
    long long temp;
    
    for (long long i = 2; i <= n; i++)
    {
        temp = (current + previous) % 10;
        previous = current;
        current = temp;
    }

    temp = current * (current + previous) % 10;

    return temp;
}

int main() {
    long long n = 0;
    std::cin >> n;
    std::cout << fibonacci_sum_squares_fast(n);
}
