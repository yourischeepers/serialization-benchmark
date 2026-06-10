# JSON Deserialization Benchmark

This repository contains the benchmark implementation used for the research paper:

> How does the deserialization time of Kotlinx Serialization compare to Google Gson for JSON datasets of varying size and object complexity in Kotlin applications?

## Overview

The project benchmarks the deserialization performance of two popular JSON libraries for Kotlin:

* [Kotlinx Serialization](https://github.com/kotlin/kotlinx.serialization)
* [Google Gson](https://github.com/google/gson)

The benchmarks measure deserialization throughput for datasets of varying size and complexity, allowing performance characteristics to be compared under different workloads.

## Benchmark Design

### Dataset Sizes

The following dataset sizes are evaluated:

* 100 objects
* 1,000 objects
* 10,000 objects

### Object Complexities

Three levels of object complexity are used:

1. **Simple**: Flat user objects with a small number of primitive fields.
2. **Medium**: User objects containing additional fields and nested objects.
3. **Complex**: Deeply nested user objects containing profiles, orders, order items, devices, metadata and collections. This complexity level is intended to simulate realistic application data structures.

## Technologies

* [Kotlin](https://github.com/JetBrains/kotlin)
* [Kotlinx Benchmark](https://github.com/kotlin/kotlinx-benchmark)
* [Kotlinx Serialization](https://github.com/kotlin/kotlinx.serialization)
* [Google Gson](https://github.com/google/gson)
* [Gradle](https://github.com/gradle/gradle) (Kotlin DSL)

## Running the Benchmarks

Run all benchmarks using:

```
./gradlew benchmark
```

Benchmark results are exported as CSV files. When using IntelliJ to open the project, a run configuration is provided. It can be found at `.idea/runConfigurations/Benchmark.xml`.

It is recommended to allocate at least 4GB of RAM when running, which can be done by using the `-Xmx4g` flag.

## Reproducibility

Datasets are generated using a deterministic random seed to ensure that identical JSON structures are used across benchmark runs.

Hardware used for the research paper:

* Computer: Apple MacBook Pro (2020, 13-inch model)
* CPU: Apple M1 Chip 
* Memory: 16GB RAM
* macOS version: Tahoe 26.2
* Java 21
* Kotlin 2.4.0

See `gradle/libs.versions.toml` for more details on the exact versions of the used libraries.

## Repository Structure

```
src/main/kotlin
├── benchmark
├── data
│   ├── generators
│   └── model
```

## Results

The benchmark results and analysis are discussed in the accompanying research paper. This repository contains only the implementation used to generate the measurements.
