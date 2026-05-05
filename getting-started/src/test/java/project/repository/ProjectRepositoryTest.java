package project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import project.domain.entity.Project;
import project.domain.entity.TaskStatus;
import project.repository.entity.ProjectEntity;
import project.repository.entity.TaskEntity;

@QuarkusTest
public class ProjectRepositoryTest {

    @Inject
    ProjectRepository projectRepository;

    @Inject
    EntityManager em;

    @Test
    @Transactional
    void userIdのみでフィルタリングする場合() {
        // テストデータのクリーンアップ
        TaskEntity.deleteAll();
        ProjectEntity.deleteAll();

        // テストデータの作成
        ProjectEntity project1 = ProjectEntity.builder()
                .userId(1L)
                .title("Project A")
                .registerDate("2023-01-01")
                .taskList(new java.util.ArrayList<>())
                .build();
        project1.persist();

        ProjectEntity project2 = ProjectEntity.builder()
                .userId(2L)
                .title("Project B")
                .registerDate("2023-01-02")
                .build();
        project2.persist();

        TaskEntity task1 = TaskEntity.builder()
                .taskName("Task 1")
                .status("0")
                .project(project1)
                .build();
        project1.getTaskList().add(task1);
        project1.persist();

        // メソッド実行
        List<Project> result = projectRepository.list(1L, null);

        // アサーション
        assertEquals(1, result.size());
        assertEquals("Project A", result.get(0).getTitle());
        assertEquals(1, result.get(0).getTaskList().size());
        assertEquals("Task 1", result.get(0).getTaskList().get(0).getTaskName());
    }

    @Test
    @Transactional
    void userIdとtitleでフィルタリングする場合() {
        // テストデータのクリーンアップ
        TaskEntity.deleteAll();
        ProjectEntity.deleteAll();

        // テストデータの作成
        ProjectEntity project1 = ProjectEntity.builder()
                .userId(1L)
                .title("Project A")
                .registerDate("2023-01-01")
                .build();
        project1.persist();

        ProjectEntity project2 = ProjectEntity.builder()
                .userId(1L)
                .title("Another Project")
                .registerDate("2023-01-02")
                .build();
        project2.persist();

        // メソッド実行
        List<Project> result = projectRepository.list(1L, "Project");

        // アサーション
        assertEquals(2, result.size());
        assertEquals("Project A", result.get(0).getTitle());
    }

    @Test
    @Transactional
    void 該当するプロジェクトがない場合() {
        // テストデータのクリーンアップ
        TaskEntity.deleteAll();
        ProjectEntity.deleteAll();

        // メソッド実行
        List<Project> result = projectRepository.list(999L, null);

        // アサーション
        assertTrue(result.isEmpty());
    }

    @Test
    @Transactional
    void createのテスト(){
        // テストデータのクリーンアップ
        // TaskEntity.deleteAll();
        // ProjectEntity.deleteAll();

        // プロジェクトの作成
        Project projectInput = Project.builder()
                .userId(1L)
                .title("New Project")
                .registerDate("2024-06-20")
                .taskList(List.of(
                    project.domain.entity.Task.builder()
                        .taskName("Task 1")
                        .status(TaskStatus.COMPLETED)
                        .build(),
                    project.domain.entity.Task.builder()
                        .taskName("Task 2")
                        .status(TaskStatus.IN_PROGRESS)
                        .build()
                ))
                .build();

        projectRepository.create(projectInput);

        // EntityManagerを使って登録したレコードを取得する
        List<ProjectEntity> projects = em.createQuery(
            "SELECT p FROM ProjectEntity p join fetch p.taskList"
        , ProjectEntity.class).getResultList();
        System.out.println("projects: " + projects);

        // データベースからプロジェクトを取得
        List<Project> result = projectRepository.list(1L, "New Project");

        System.out.println("test input");
        System.out.println(result);

        // // アサーション
        // assertEquals(1, result.size());
        // assertEquals("New Project", result.get(0).getTitle());
        // assertEquals(2, result.get(0).getTaskList().size());
    }
}
