# [Server]Cluster (MariaDB:Galera Cluster, Oracle:Real Application Cluster)

# Cluster?

- 2대 이상의 머신이 협력하여 마치 한 대의 머신이 서비스하는 것처럼 동작하는 시스템.
- Cluster를 구성하는 각 머신을 Node라고 부름.
- Node들이 평소에 모두 서비스 수행에 참여하는 형태의 구성을 Active-Active형태의  Cluster.
- 평소에 서비스는 하나의 Node가 수행을 하되 해당Node에 장애가 발생할 경우 대기중에 있던 Node로 교체되어(failover) 서비스가 지속되게 하는 형태의 구성을 Active-Passive 혹은 Active-Standby 형태의 Cluster라고 부름.

# Why?

- 고가용성(HA:High Availability 혹은 이중화)로 인하여 사용.
- High Availability
    - 하나의 머신에 고장이 발생했을 경우 서비스가 중단되지 않고 계속될 수 있도록 동일 어플리케이션 모듈을 실행하는 다수의 머신을 두는 것.

# MariaDB(MariaDB Cluster / Galera Cluster)

- 기본적으로 3대의 Node로 구성.
- 자신의 로컬 스토리지에 데이터를 저장하고 변경이 발생할 때 실시간으로 복제(Replication)의 Shared Nothing 방식의 Cluster
- Node 수를 곱한 만큼의 스토리지 용량이 필요.
- 2대의 Node로만 구성하고 싶을 때는 별도의 머신에 gardb(Galera Arbitrator Daemon)이라는 스토리지 용량은 차지하지 않는 가상 MariaDB 역할을 수행하는 모듈을 두어 3대의 Node처럼 구성해야함.
- 각 Node들에 write가 발생할 때마다 모든 Node들에 복제가 되기 때문에 write 성능은 증가하지 않으나 read 성능은 증가하게 된다.

# Oracle Cluster(RAC)

- Node들이 스토리지를 공유하는 Shared Disk 방식을 사용
- Node 수에 비례해 스토리지 용량이 늘어나지는 않으나 Node 수가 늘어날수록 공유 스토리지에 대한 경쟁은 증가하게 된다,

> etc

- sizing
    - 사용자수를 고려하여 전체 시스템에서 사용할 서버의 구성과 스토리지 용량 등을 산정하는 작업.